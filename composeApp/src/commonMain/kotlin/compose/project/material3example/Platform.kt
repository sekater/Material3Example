package compose.project.material3example

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform