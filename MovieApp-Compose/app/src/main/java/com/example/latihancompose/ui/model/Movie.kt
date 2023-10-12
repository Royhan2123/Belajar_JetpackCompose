package com.example.latihancompose.ui.model

data class Movie(
    val id: String,
    val title: String,
    val year: String,
    val genre: String,
    val director: String,
    val actors: String,
    val plot: String,
    val image: String,
    val rating: String
)

fun getMovies(): List<Movie> {
    return listOf(
        Movie(
            id = "0019201",
            title = "Headshot",
            year = "2016",
            genre = "Action, Adventure, Fantasy",
            director = "James Cameron",
            actors = "Quwais",
            plot = "A comatose man of unknown identity and origin is being cared by Dr. Ailin in a rural hospital on a small island. The man eventually wakes up after two months with no clear memory of how he was injured or even his identity. He adopts the name Ishmael from Moby-Dick, which Ailin is reading. The man learns that he was found on the beach by a man named Romli.",
            image = "https://upload.wikimedia.org/wikipedia/en/6/6c/Headshot_%282016_film%29.jpg",
            rating = "7.9"
        ),

        Movie(
            id = "00192721",
            title = "Spiderman",
            year = "2006",
            genre = "Action, Drama, Fantasy",
            director = "Zack Snyder",
            actors = "peter parker",
            plot = "Spider-Man's secret identity is Peter Benjamin Parker. Initially, Peter was depicted as a teenage high school student and an orphan raised by his Aunt May and Uncle Ben in New York City after his parents Richard and Mary Parker died in a plane crash. Lee and Ditko had the character deal with the struggles of adolescence and financial issues and gave him many supporting characters, such as Flash Thompson, J. Jonah Jameson, and Harry Osborn; romantic interests Gwen Stacy, Mary Jane Watson, and the Black Cat; and enemies such as the Green Goblin, Doctor Octopus, and Venom. ",
            image = "https://upload.wikimedia.org/wikipedia/en/2/21/Web_of_Spider-Man_Vol_1_129-1.png",
            rating = "7.7"
        ),

        Movie(
            id = "00182912",
            title = "Gundala",
            year = "2012",
            genre = "Action, Sci-Fi, Thriller",
            director = "Joss Whedon",
            actors = "Atta Halilintar,Rizky Nasar",
            plot = "Sancaka (Muzakki Ramdhan) adalah putra seorang pekerja pabrik miskin yang berjuang untuk memenuhi kebutuhan hidup. Sancaka yang masih muda itu menunjukkan tanda-tanda kecemerlangan dalam mengutak-atik produk listrik, tetapi takut dengan petir dan badai yang seakan selalu mengincarnya. Ayah Sancaka (Rio Dewanto) memimpin rekan-rekan buruh pabriknya dalam sebuah protes terhadap pemilik pabrik, menuntut kenaikan gaji. Kelompok itu bertemu dengan penjaga bersenjata yang disewa oleh pemilik pabrik, lalu protes itu berubah menjadi anarkis. Pada protes kedua, ayah Sancaka dikhianati dan ditikam oleh rekan-rekannya yang telah disuap oleh pemilik pabrik dan meninggal di lengan Sancaka.",
            image = "https://upload.wikimedia.org/wikipedia/id/d/de/Gundala_%282019%29_poster.jpg",
            rating = "8.1"
        ),

        Movie(
            id = "00928172",
            title = "Rampage",
            year = "2013",
            genre = "Biography, Comedy, Crime",
            director = "Martin Scorsese",
            actors = "Dwayne Jonson",
            plot = "Rampage adalah film fiksi ilmiah Amerika Serikat tahun 2018 yang disutradarai oleh Brad Peyton, dan berdasarkan pada seri video game dengan nama yang sama oleh Midway Games. Bintang film antara lain Dwayne Johnson, Naomie Harris, Malin Åkerman, Jake Lacy dan Jeffrey Dean Morgan. Film ini bercerita tentang seorang ahli primata bernama Davis Okoye, yang harus bekerja sama dengan George, gorila albino yang berubah menjadi makhluk yang mengamuk dengan ukuran besar setelah percobaan nakal untuk menghentikan dua monster raksasa lainnya.",
            image = "https://upload.wikimedia.org/wikipedia/id/6/6b/Rampage_teaser_film_poster.jpg",
            rating = "8.2"
        ),

        Movie(
            id = "019281",
            title = "Tomb Raider",
            year = "2014",
            genre = "Adventure, Drama, Sci-Fi",
            director = "Christopher Nolan",
            actors = "Ellen Burstyn, Matthew McConaughey, Mackenzie Foy, John Lithgow",
            plot = "Tomb Raider adalah film aksi-petualangan tahun 2018 yang disutradarai oleh Roar Uthaug dengan skenario oleh Geneva Robertson-Dworet dan Alastair Siddons, ide cerita oleh Evan Daugherty dan Robertson-Dworet. Film ini berdasarkan pada video game 2013 dengan nama yang sama, dengan beberapa elemen sekuelnya oleh Crystal Dynamics dan merupakan reboot dari seri film Tomb Raider. Film ini dibintangi Alicia Vikander sebagai Lara Croft, di mana ia memulai perjalanan berbahaya ke tujuan terakhir ayahnya, berharap untuk memecahkan misteri hilangnya ayahnya. Dominic West, Walton Goggins, Daniel Wu dan Kristin Scott Thomas muncul dalam film sebagai pemeran pendukung.",
            image = "https://upload.wikimedia.org/wikipedia/id/b/bd/Tomb_Raider_%282018_film%29.png",
            rating = "8.6"
        ),
        Movie(
            id = "0092141",
            title = "Baaghi 3",
            year = "2020",
            genre = "Adventure, Drama, Fantasy",
            director = "N/A",
            actors = "Sharukkan",
            plot = "Ranveer \"Ronnie\" Charan Chaturvedi lives with his elder brother Vikram. Ronnie has been protective towards him since childhood, especially after their father Charan Chaturvedi's death. Ronnie is offered a job in the police force, but refuses because he has 33 cases registered against him all for saving Vikram and convinces him to take on the job. ",
            image = "https://upload.wikimedia.org/wikipedia/en/2/26/Baaghi_3_Film_Poster.jpg",
            rating = "9.5"
        ),


        Movie(
            id = "0028271",
            title = "Jumanji",
            year = "2020",
            genre = "Action, Drama, History",
            director = "N/A",
            actors = "Dwayne Jonson,Kevin Hart",
            plot = "In 1996, Brantford, New Hampshire, teenager Alex Vreeke receives Jumanji, which was previously disposed of by Alan Parrish and Sarah Whittle in 1969,[a] from his father, who found it on the coast. Later that night, Alex finds it transformed into a video game cartridge. Opting to play, he is sucked inside the game, disappearing from the real world as time continues to pass",
            image = "https://upload.wikimedia.org/wikipedia/en/d/dc/Jumanji_Welcome_to_the_Jungle.png",
            rating = "9.5"
        ),

        Movie(
            id = "00129281",
            title = "Kingkong",
            year = "2017",
            genre = "Crime, Drama, Thriller,Horror",
            director = "N/A",
            actors = "Bryan Cranston, Anna Gunn, Aaron Paul, Dean Norris",
            plot = "In 1973, Bill Randa, head of the U.S. government organization Monarch, plans a search for primeval creatures on the recently discovered Skull Island. He recruits a U.S. Army unit commanded by Lieutenant Colonel Preston Packard, tracker and former British Special Air Service Captain James Conrad, and anti-war photographer Mason Weaver. Arriving at Skull Island, Packard's men begin dropping seismic explosives, developed by Randa's seismologist Houston Brooks, to map out the island and prove Brooks' Hollow Earth theory.",
            image = "https://upload.wikimedia.org/wikipedia/en/3/34/Kong_Skull_Island_poster.jpg",
            rating = "9.5"
        ),

        Movie(
            id = "01289271",
            title = "The Hobbit",
            year = "2016",
            genre = "Biography, Crime, Drama,Fantasy",
            director = "N/A",
            actors = "Wagner Moura, Boyd Holbrook, Pedro Pascal, Joanna Christie",
            plot = "Thorin Oakenshield and his company are being pursued by Azog and his Orc party. They are ushered by Gandalf to the nearby home of Beorn, a skin-changer who can take the form of a bear. That night, Azog is summoned to Dol Guldur by the Necromancer, who commands him to marshal his forces for war. Azog delegates the hunt for Thorin to his son Bolg. ",
            image = "https://upload.wikimedia.org/wikipedia/en/4/4f/The_Hobbit_-_The_Desolation_of_Smaug_theatrical_poster.jpg",
            rating = "9.5"
        ),
        Movie(
            id = "08127012",
            title = "Jumper",
            year = "2008",
            genre = "Biography, Crime, Drama,Fantasy",
            director = "N/A",
            actors = "Hayden,Jamie Bell,Rachel Bilson",
            plot = "One day David is confronted by Roland, a leader of the Paladins or Jumper hunters who believe Jumpers are abominations. Despite Roland using specialized weapons which disrupt a Jumper’s teleportation abilities, David still escapes to his hometown in Ann Arbor. There, he finds his high school crush Millie and also runs into his former high school bully Mark. They fight and David jumps him into a bank vault he had robbed years earlier.",
            image = "https://upload.wikimedia.org/wikipedia/en/3/37/Jumperposter.jpg",
            rating = "8.0"
        ),
        )
}

fun getMoviesHorror(): List<Movie> {
    return listOf(
        Movie(
            id = "tt0499549",
            title = "Khanzab",
            year = "2023",
            genre = "Horror,Drama",
            director = "Pak Abdul",
            actors = "Pak Abdul",
            plot = "A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.",
            image = "https://upload.wikimedia.org/wikipedia/id/4/4c/Khanzab_%282023%29.jpg",
            rating = "7.9"
        ),

        Movie(
            id = "tt0416449",
            title = "Waktu Maghrib",
            year = "2023",
            genre = "Horror,Drama,Mistic",
            director = "Zack Snyder",
            actors = "Gerard Butler, Lena Headey, Dominic West, David Wenham",
            plot = "King Leonidas of Sparta and a force of 300 men fight the Persians at Thermopylae in 480 B.C.",
            image = "https://upload.wikimedia.org/wikipedia/id/7/77/Poster_Waktu_Maghrib.jpg",

            rating = "7.7"
        ),

        Movie(
            id = "tx09281",
            title = "Evil Dead Rise",
            year = "2023",
            genre = "Action, Horror, Thriller",
            director = "Joss Whedon",
            actors = "Robert Downey Jr., Chris Evans, Mark Ruffalo, Chris Hemsworth",
            plot = "Earth's mightiest heroes must come together and learn to fight as a team if they are to stop the mischievous Loki and his alien army from enslaving humanity.",
            image = "https://lsf.go.id/wp-content/uploads/2023/04/PF-Evil-Dead-Rise_page-0001-350x520.jpg",
            rating = "8.1"
        ),

        Movie(
            id = "tx01921",
            title = "The Medium",
            year = "2021",
            genre = "Horror,Thriller,Paranormal",
            director = "Martin Scorsese",
            actors = "Leonardo DiCaprio, Jonah Hill, Margot Robbie, Matthew McConaughey",
            plot = "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.",
            image = "https://upload.wikimedia.org/wikipedia/id/7/73/The_Medium_film_poster.jpg",
            rating = "8.2"
        ),

        Movie(
            id = "tt0816692",
            title = "Us",
            year = "2019",
            genre = "Paranormal,Looping,Horror",
            director = "Christopher Nolan",
            actors = "Ellen Burstyn, Matthew McConaughey, Mackenzie Foy, John Lithgow",
            plot = "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
            image = "https://upload.wikimedia.org/wikipedia/id/0/00/Us_%282019%29_theatrical_poster.png",
            rating = "8.6"
        ),
        Movie(
            id = "tt0944947",
            title = "Ivanna",
            year = "2022",
            genre = "Horror,Action,Drama,Thriller",
            director = "N/A",
            actors = "Peter Dinklage, Lena Headey, Emilia Clarke, Kit Harington",
            plot = "While a civil war brews between several noble families in Westeros, the children of the former rulers of the land attempt to rise up to power. Meanwhile a forgotten race, bent on destruction, plans to return after thousands of years in the North.",
            image = "https://upload.wikimedia.org/wikipedia/id/3/32/Poster_Ivanna.jpeg",
            rating = "9.5"
        ),
        Movie(
            id = "tt2306299",
            title = "Megan",
            year = "2022",
            genre = "Action, Drama, Thriller",
            director = "N/A",
            actors = "Travis Fimmel, Clive Standen, Gustaf Skarsgård, Katheryn Winnick",
            plot = "The world of the Vikings is brought to life through the journey of Ragnar Lothbrok, the first Viking to emerge from Norse legend and onto the pages of history - a man on the edge of myth.",
            image = "https://upload.wikimedia.org/wikipedia/id/0/03/M3GAN_Poster.jpeg",
            rating = "9.5"
        ),

        Movie(
            id = "tt0903747",
            title = "Insidious The Red Door",
            year = "2023",
            genre = "Crime, Drama, Thriller",
            director = "N/A",
            actors = "Bryan Cranston, Anna Gunn, Aaron Paul, Dean Norris",
            plot = "A high school chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine in order to secure his family's financial future.",
            image = "https://upload.wikimedia.org/wikipedia/id/4/4f/Insidious_the_red_door.png",
            rating = "9.5"
        ),

        Movie(
            id = "tt2707408",
            title = "Ratu Ilmu Hitam",
            year = "2022",
            genre = "Biography, Crime, Drama",
            director = "N/A",
            actors = "Wagner Moura, Boyd Holbrook, Pedro Pascal, Joanna Christie",
            plot = "A chronicled look at the criminal exploits of Colombian drug lord Pablo Escobar.",
            image = "https://upload.wikimedia.org/wikipedia/id/6/68/Poster_film_Ratu_Ilmu_Hitam_2019.jpg",
            rating = "9.5"
        ),

        Movie(
            id = "tt028172",
            title = "The Nun II",
            year = "2023",
            genre = "Biography, Crime, Drama,Horror",
            director = "N/A",
            actors = "Wagner Moura, Boyd Holbrook, Pedro Pascal, Joanna Christie",
            plot = "The Nun II (also known as The Nun: Chapter Two) is a 2023 American gothic supernatural horror film directed by Michael Chaves, with a screenplay written by Ian Goldberg, Richard Naing, and Akela Cooper from a story by Cooper.[ 6] Serving as a sequel to The Nun (2018) and the eighth installment in The Conjuring Universe franchise, the film stars Taissa Farmiga, Jonas Bloquet and Bonnie Aarons, returning from the first film, with Storm Reid and Anna Popplewell joining the cast . Peter Safran and James Wan return as producers.",
            image = "https://upload.wikimedia.org/wikipedia/id/b/bc/The_Nun_II_%282023%29.jpg",
            rating = "9.5"
        ),

        )
}

fun getMoviesAventure(): List<Movie> {
    return listOf(
        Movie(
            id = "tt0499549",
            title = "Super Mario",
            year = "2023",
            genre = "Adventure,Action,Fantasy,Game",
            director = "Pak Abdul",
            actors = "Pak Abdul",
            plot = "A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.",
            image = "https://www.mnctrijaya.com/uploads/news/IMG-20230406-WA0011.jpg",
            rating = "7.9"
        ),

        Movie(
            id = "tt0416449",
            title = "Jumanji",
            year = "2023",
            genre = "Adventure,Action",
            director = "Zack Snyder",
            actors = "Gerard Butler, Lena Headey, Dominic West, David Wenham",
            plot = "King Leonidas of Sparta and a force of 300 men fight the Persians at Thermopylae in 480 B.C.",
            image = "https://img.okezone.com/content/2023/03/31/206/2791005/sinopsis-film-jumanji-the-next-level-petualangan-dwayne-johnson-makin-sulit-lh8Z9b7Bux.jpg",

            rating = "7.7"
        ),

        Movie(
            id = "tt0848228",
            title = "Mortal Kombat",
            year = "2012",
            genre = "Action, Sci-Fi, Thriller",
            director = "Joss Whedon",
            actors = "Robert Downey Jr., Chris Evans, Mark Ruffalo, Chris Hemsworth",
            plot = "Earth's mightiest heroes must come together and learn to fight as a team if they are to stop the mischievous Loki and his alien army from enslaving humanity.",
            image = "https://akcdn.detik.net.id/visual/2021/04/14/mortal-kombat-2021-2_169.png?w=650&q=90",
            rating = "8.1"
        ),

        Movie(
            id = "tt0993846",
            title = "Minions",
            year = "2013",
            genre = "Biography, Comedy, Crime",
            director = "Martin Scorsese",
            actors = "Leonardo DiCaprio, Jonah Hill, Margot Robbie, Matthew McConaughey",
            plot = "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.",
            image = "https://upload.wikimedia.org/wikipedia/id/4/45/Minions_The_Rise_of_Gru_poster.jpg",
            rating = "8.2"
        ),

        Movie(
            id = "tt0816692",
            title = "SpongeBob Movie",
            year = "2014",
            genre = "Adventure, Drama, Sci-Fi",
            director = "Christopher Nolan",
            actors = "Ellen Burstyn, Matthew McConaughey, Mackenzie Foy, John Lithgow",
            plot = "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
            image = "https://upload.wikimedia.org/wikipedia/id/3/34/The_SpongeBob_Movie_-_Sponge_on_the_Run.png",
            rating = "8.6"
        ),
        Movie(
            id = "tt0944947",
            title = "Dora The Explorer",
            year = "2011 - 2018",
            genre = "Adventure, Drama, Fantasy",
            director = "N/A",
            actors = "Peter Dinklage, Lena Headey, Emilia Clarke, Kit Harington",
            plot = "While a civil war brews between several noble families in Westeros, the children of the former rulers of the land attempt to rise up to power. Meanwhile a forgotten race, bent on destruction, plans to return after thousands of years in the North.",
            image = "https://upload.wikimedia.org/wikipedia/id/b/b7/DoraLostCityOfGoldTeaserPoster.jpeg",
            rating = "9.5"
        ),
        Movie(
            id = "tt2306299",
            title = "The Boss Baby",
            year = "2013–2020",
            genre = "Action, Drama, History",
            director = "N/A",
            actors = "Travis Fimmel, Clive Standen, Gustaf Skarsgård, Katheryn Winnick",
            plot = "The world of the Vikings is brought to life through the journey of Ragnar Lothbrok, the first Viking to emerge from Norse legend and onto the pages of history - a man on the edge of myth.",
            image = "https://upload.wikimedia.org/wikipedia/en/0/0e/The_Boss_Baby_poster.jpg",
            rating = "9.5"
        ),
        Movie(
            id = "tt0903747",
            title = "Golden Compas",
            year = "2008–2013",
            genre = "Crime, Drama, Thriller",
            director = "N/A",
            actors = "Bryan Cranston, Anna Gunn, Aaron Paul, Dean Norris",
            plot = "A high school chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine in order to secure his family's financial future.",
            image = "https://resizing.flixster.com/KILWksHSR1xTFuOqRkCM3kgkSt0=/206x305/v2/https://flxt.tmsimg.com/assets/p170996_p_v8_ba.jpg",
            rating = "9.5"
        ),

        Movie(
            id = "tt2707408",
            title = "Indiana Jones",
            year = "2015",
            genre = "Biography, Crime, Drama",
            director = "N/A",
            actors = "Wagner Moura, Boyd Holbrook, Pedro Pascal, Joanna Christie",
            plot = "A chronicled look at the criminal exploits of Colombian drug lord Pablo Escobar.",
            image = "https://img.antaranews.com/cache/1200x800/2023/06/28/indy.jpg.webp",
            rating = "9.5"
        ),
        Movie(
            id = "tt0128722",
            title = "Uncharted ",
            year = "2022",
            genre = "Biography, Crime, Drama",
            director = "N/A",
            actors = "Wagner Moura, Boyd Holbrook, Pedro Pascal, Joanna Christie",
            plot = "Orphaned brothers Sam and Nathan \"Nate\" Drake are caught trying to steal a map made after the Magellan expedition from a Boston museum. Before the orphanage can expel Sam, he sneaks out to be on his own, but promises Nate that he will return, leaving him a ring belonging to their ancestor Sir Francis Drake (although the real Sir Francis Drake actually had no children).",
            image = "https://upload.wikimedia.org/wikipedia/en/d/d4/Uncharted_Official_Poster.jpg",
            rating = "9.5"
        ),
    )
}