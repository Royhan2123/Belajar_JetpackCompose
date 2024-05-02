@file:Suppress("DEPRECATION")

package com.example.jetpackcomposeapi.page

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Chip
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeapi.R
import com.example.jetpackcomposeapi.ui.theme.blue
import com.example.jetpackcomposeapi.ui.theme.grey
import com.example.jetpackcomposeapi.ui.theme.lightGray
import com.example.jetpackcomposeapi.widget.CardDestination
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Locale
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


suspend fun getAddressFromLocation(context: Context, location: Location): String {
    return withContext(Dispatchers.IO) {
        val geocoder = Geocoder(context, Locale.getDefault())
        val addresses = geocoder.getFromLocation(location.latitude, location.longitude, 1)
        if (addresses!!.isNotEmpty()) {
            val address = addresses[0]
            address.getAddressLine(0) ?: "Unknown"
        } else {
            "Unknown"
        }
    }
}

suspend fun getLocation(context: Context, fusedLocationClient: FusedLocationProviderClient): Location? {
    return suspendCoroutine { continuation ->
        if (ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                context as Activity,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                1
            )
            continuation.resume(null)
        } else {
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location? ->
                    continuation.resume(location)
                }
        }
    }
}

@Composable
fun HomeScreen(
    navController: NavController
) {
    var txfSearch by rememberSaveable {
        mutableStateOf("")
    }
    var selectedOption by rememberSaveable {
        mutableStateOf(listOf<String>())
    }

    var locationText by remember { mutableStateOf("Location: Unknown") }
    val context = LocalContext.current
    val fusedLocationClient = remember(context) {
        LocationServices.getFusedLocationProviderClient(context)
    }
    LaunchedEffect(Unit) {
        val location = withContext(Dispatchers.IO) {
            getLocation(context, fusedLocationClient)
        }
        location?.let {
            val currentAddress = getAddressFromLocation(context, location)
            locationText = "Location: $currentAddress"
        }
    }

    LaunchedEffect(Unit) {
        // Check if location permission is granted
        if (ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Request location permission
            ActivityCompat.requestPermissions(
                context as Activity,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                1
            )
        } else {
            // If permission is granted, get the last known location
            val location = withContext(Dispatchers.IO) {
                getLocation(context, fusedLocationClient)
            }
            location?.let {
                // Update locationText with the current address
                val currentAddress = getAddressFromLocation(context, location)
                locationText = "Location: $currentAddress"
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Hello, Royhan",
                    fontSize = 17.sp,
                )
                Text(
                    text = "How are you today?",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clickable {
                            locationText
                                .takeIf { it != "Location: Unknown" }
                                ?.let { currentLocation ->
                                    val currentLocationUri =
                                        Uri.parse("geo:${currentLocation.substringAfter("")}?q=$currentLocation")
                                    val mapIntent = Intent(Intent.ACTION_VIEW, currentLocationUri)
                                    mapIntent.setPackage("com.google.android.apps.maps")
                                    startActivity(context, mapIntent, null)
                                }
                        }
                        .width(150.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = "icon-location",
                        tint = Color.Red,
                        modifier = Modifier.size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(
                        text = locationText.removePrefix("Location: "),
                        fontSize = 13.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Surface(
                modifier = Modifier
                    .height(75.dp)
                    .width(75.dp),
                color = lightGray,
                shape = CircleShape
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.CameraAlt,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = Color.Black
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        OutlinedTextField(
            value = txfSearch,
            onValueChange = { txfSearch = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            placeholder = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Search your destination...",
                        fontSize = 15.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold,
                    )
                }
            },
            textStyle = TextStyle(
                fontSize = 15.sp,
                color = Color.Black,
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Gray
                )
            },
            shape = RoundedCornerShape(size = 15.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TourismOptionChip(
                text = "Recommended",
                selected = selectedOption.contains("Recommended"),
                onClick = {
                    selectedOption = if (selectedOption.contains("Recommended")) {
                        selectedOption.filter { it != "Recommended" }
                    } else {
                        selectedOption + listOf("Recommended")
                    }
                }
            )

            TourismOptionChip(
                text = "Intresting",
                selected = selectedOption.contains("Intresting"),
                onClick = {
                    selectedOption = if (selectedOption.contains("Intresting")) {
                        selectedOption.filter { it != "Intresting" }
                    } else {
                        selectedOption + listOf("Intresting")
                    }
                }
            )

            TourismOptionChip(
                text = "Nearest",
                selected = selectedOption.contains("Nearest"),
                onClick = {
                    selectedOption = if (selectedOption.contains("Nearest")) {
                        selectedOption.filter { it != "Nearest" }
                    } else {
                        selectedOption + listOf("Nearest")
                    }
                }
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TourismOptionChip(
                text = "Best",
                selected = selectedOption.contains("Best"),
                onClick = {
                    selectedOption = if (selectedOption.contains("Best")) {
                        selectedOption.filter { it != "Best" }
                    } else {
                        selectedOption + listOf("Best")
                    }
                }
            )
            TourismOptionChip(
                text = "Cheapest",
                selected = selectedOption.contains("Cheapest"),
                onClick = {
                    selectedOption = if (selectedOption.contains("Cheapest")) {
                        selectedOption.filter { it != "Cheapest" }
                    } else {
                        selectedOption + listOf("Cheapest")
                    }
                }
            )
            TourismOptionChip(
                text = "Mountains",
                selected = selectedOption.contains("Mountains"),
                onClick = {
                    selectedOption = if (selectedOption.contains("Mountains")) {
                        selectedOption.filter { it != "Mountains" }
                    } else {
                        selectedOption + listOf("Mountains")
                    }
                }
            )
            TourismOptionChip(
                text = "View",
                selected = selectedOption.contains("View"),
                onClick = {
                    selectedOption = if (selectedOption.contains("View")) {
                        selectedOption.filter { it != "View" }
                    } else {
                        selectedOption + listOf("View")
                    }
                }
            )
        }
        Spacer(modifier = Modifier.height(70.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            CardDestination(
                nameCity = "Bali",
                nameDestination = "Monkey Forest",
                rating = 4.2,
                image = R.drawable.monkey_forest
            )
            Spacer(modifier = Modifier.width(20.dp))
            CardDestination(
                nameCity = "Bali",
                nameDestination = "Pura Besakih",
                rating = 4.8,
                image = R.drawable.pura_besakih
            )
            Spacer(modifier = Modifier.width(20.dp))

            CardDestination(
                nameCity = "Bali",
                nameDestination = "Seminyak",
                rating = 4.5,
                image = R.drawable.seminyak
            )
            Spacer(modifier = Modifier.width(20.dp))

            CardDestination(
                nameCity = "Bali",
                nameDestination = "Gunung Batur",
                rating = 4.3,
                image = R.drawable.gunung_batur
            )
            Spacer(modifier = Modifier.width(20.dp))

            CardDestination(
                nameCity = "Bali",
                nameDestination = "Air Terjun Tegunungan",
                rating = 5.0,
                image = R.drawable.air_terjun_tegunungan
            )
        }
    }
}




@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TourismOptionChip(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Chip(
        modifier = Modifier.padding(end = 8.dp),
        colors = ChipDefaults.chipColors(
            if (selected) blue else lightGray,
        ),
        onClick = onClick
    ) {
        Text(
            text = text,
            color = if (selected) Color.White else grey,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}


@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen(navController = rememberNavController())
}