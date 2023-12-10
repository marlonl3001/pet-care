class JVMPlatform: Platform {
    override val name: Strings = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = JVMPlatform()