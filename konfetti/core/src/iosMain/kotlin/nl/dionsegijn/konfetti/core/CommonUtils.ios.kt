package nl.dionsegijn.konfetti.core

import platform.Foundation.NSDate
import platform.Foundation.timeIntervalSince1970

actual fun getSystemTimeInMillis(): Long = NSDate().timeIntervalSince1970.toLong() * 1000