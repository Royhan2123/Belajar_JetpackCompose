package com.example.latihanroomcompose

sealed interface ContactEvent {
    object saveContact: ContactEvent
    data class setFirstName(val firstName: String):ContactEvent
    data class setLastName(val lastName: String):ContactEvent
    data class setPhoneNumber(val phoneNumber: String):ContactEvent

    object ShowDialog:ContactEvent
    object HideDialog:ContactEvent
    data class SortContacts(val sortType: SortType) : ContactEvent
    data class DeleteContact(val contact: Contact) : ContactEvent

}