package com.zz.yang.test.rx

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Environment
import android.util.Log
import android.webkit.CookieManager
import java.net.URLDecoder

object LogUtil {
    private const val STACK_TRACE_INDEX = 3
    private var isFileLog = false
    private val LOG = true
    fun d() {
        if (LOG) {
            val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
            val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
            if (isFileLog) {
//                getLogger(trace).debug("log")
            } else {
                d("[$trace]", "log")
            }
        }
    }

    fun d(msg: Int) {
        val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
        val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
        if (isFileLog) {
//            getLogger(trace).debug(msg)
        } else {
            d("[$trace]", "" + msg)
        }
    }

    @JvmStatic
    fun d(msg: String) {
        if (LOG) {
            val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
            val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
            if (isFileLog) {
//                getLogger(trace).debug(msg)
            } else {
                d("[$trace]", msg)
            }
        }
    }

    fun d(msg: Any) {
        if (LOG) {
            val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
            val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
            if (isFileLog) {
//                getLogger(trace).debug(msg)
            } else {
                d("[$trace]", msg.toString() + "")
            }
        }
    }

    @JvmStatic
	fun d(TAG: String?, msg: String?) {
        if (LOG) {
            Log.d(TAG, msg ?: "null")

        }
    }

    fun i() {
        if (LOG) {
            val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
            val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
            if (isFileLog) {
//                getLogger(trace).info("log")
            } else {
                Log.i("[$trace]", "log")
            }
        }
    }

    fun i(msg: Int) {
        if (LOG) {
            val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
            val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
            if (isFileLog) {
//                getLogger(trace).info(msg)
            } else {
                Log.i("[$trace]", "" + msg)
            }
        }
    }

    @JvmStatic
    fun i(msg: String) {
        if (LOG) {
            val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
            val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
            if (isFileLog) {
//                getLogger(trace).info(msg)
            } else {
                Log.i("[$trace]", msg)
            }
        }
    }

    fun i(msg: Any?) {
        if (LOG) {
            val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
            val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
            if (isFileLog) {
//                getLogger(trace).info(msg)
            } else {
                Log.i("[$trace]", msg.toString() + "")
            }
        }
    }

    fun w() {
        if (LOG) {
            val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
            val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
            if (isFileLog) {
//                getLogger(trace).warn("log")
            } else {
                Log.i("[$trace]", "log")
            }
        }
    }

    fun w(msg: Int) {
        if (LOG) {
            val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
            val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
            if (isFileLog) {
//                getLogger(trace).warn(msg)
            } else {
                Log.i("[$trace]", "" + msg)
            }
        }
    }

    fun w(msg: String?) {
        if (LOG) {
            val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
            val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
            if (isFileLog) {
//                getLogger(trace).warn(msg)
            } else {
                Log.i("[$trace]", msg ?: "null")
            }
        }
    }

    fun w(msg: Any) {
        if (LOG) {
            val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
            val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
            if (isFileLog) {
//                getLogger(trace).warn(msg)
            } else {
                Log.i("[$trace]", msg.toString() + "")
            }
        }
    }

    fun v() {
        if (LOG) {
            val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
            val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
            if (isFileLog) {
//                getLogger(trace).warn("log")
            } else {
                Log.i("[$trace]", "log")
            }
        }
    }

    fun v(msg: Int) {
        if (LOG) {
            val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
            val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
            if (isFileLog) {
//                getLogger(trace).warn(msg)
            } else {
                Log.i("[$trace]", "" + msg)
            }
        }
    }

    fun v(msg: String?) {
        if (LOG) {
            val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
            val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
            if (isFileLog) {
//                getLogger(trace).warn(msg)
            } else {
                Log.i("[$trace]", msg ?: "null")
            }
        }
    }

    fun v(msg: Any) {
        if (LOG) {
            val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
            val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
            if (isFileLog) {
//                getLogger(trace).warn(msg)
            } else {
                Log.i("[$trace]", msg.toString() + "")
            }
        }
    }

    fun e() {
        if (LOG) {
            val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
            val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
            if (isFileLog) {
//                getLogger(trace).error("log")
            } else {
                Log.e("[$trace]", "LOG")
            }
        }
    }

    @JvmStatic
    fun e(msg: Exception) {
        if (LOG) {
            val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
            val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
            if (isFileLog) {
//                getLogger(trace).error(msg)
            } else {
                Log.e("[$trace]", "" + msg)
                msg.printStackTrace()
            }
        }
    }

    @JvmStatic
    fun e(msg: String) {
        if (LOG) {
            val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
            val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
            if (isFileLog) {
//                getLogger(trace).error(msg)
            } else {
                Log.e("[$trace]", "" + msg)
            }
        }
    }

    @JvmStatic
    fun e(msg: OutOfMemoryError) {
        if (LOG) {
            val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
            val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
            if (isFileLog) {
//                getLogger(trace).error(msg)
            } else {
                Log.e("[$trace]", "" + msg)
            }
        }
    }

    @JvmStatic
	fun e(msg: Throwable) {
        if (LOG) {
            val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
            val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
            if (isFileLog) {
//                getLogger(trace).error(msg)
            } else {
                Log.e("[$trace]", "" + msg)
                msg.printStackTrace()
            }
        }
    }

    fun dLine() {
        if (LOG) {
            val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
            val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
            if (isFileLog) {
//                getLogger(trace).debug("----------------------------------------------------")
            } else {
                d("[$trace]", "----------------------------------------------------")
            }
        }
    }

    fun memory() {
        if (LOG) {
            val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
            val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
            val msg = "totalMemory : " + Runtime.getRuntime().totalMemory() + ", maxMemory : " + Runtime.getRuntime().maxMemory() + ", freeMemory :" + Runtime.getRuntime().freeMemory()
            if (isFileLog) {
//                getLogger(trace).warn(msg)
            } else {
                Log.w("[$trace]", msg)
            }
        }
    }

    fun intent(i: Intent?) {
        if (LOG) {
            val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
            val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
            val sb = StringBuilder()
            try {
                if (isFileLog) {
//                    getLogger(trace).error("------------------------intent------------------------")
                } else {
                    Log.e("[$trace]", "------------------------intent------------------------")
                }
                sb.append("\nintent = $i")
                if (i != null) {
                    val extras = i.extras
                    sb.append("\nextras = $extras")
                    if (extras != null) {
                        val keys = extras.keySet()
                        sb.append("++ bundle key count = ${keys.size}".trimIndent())
                        for (_key in extras.keySet()) {
                            sb.append("-key=$_key : ${extras[_key]}")
                        }
                    }
                }
                if (isFileLog) {
//                    getLogger(trace).error(sb.toString())
                } else {
                    Log.e("[$trace]", sb.toString())
                }
            } catch (e: Exception) {
                if (isFileLog) {
//                    getLogger(trace).error(e.toString())
                } else {
                    Log.e("[$trace]", e.toString())
                }
            } finally {
                if (isFileLog) {
//                    getLogger(trace).error("------------------------intent------------------------")
                } else {
                    Log.e("[$trace]", "------------------------intent------------------------")
                }
            }
        }
    }

    fun taskStack(context: Context) {
        if (LOG) {
            val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
            val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
            if (isFileLog) {
//                getLogger(trace).error("------------------------taskStack---------------------------")
//                getLogger(trace).error("current package name = " + context.packageName)
            } else {
                Log.e("[$trace]", "------------------------taskStack---------------------------")
                Log.e("[$trace]", "current package name = " + context.packageName)
            }
            try {
                val am = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
                val taskList = am.getRunningTasks(10)
                for (i in taskList.indices) {
                    val runInfo = taskList[i]
                    val base = runInfo.baseActivity
                    val top = runInfo.topActivity
                    val sb = StringBuilder()
                    sb.append("\ntaskList.get( $i ).runInfo.id = ${runInfo.id}")
                    if (base!!.packageName == context.packageName) {
                        sb.append("\n\t-runInfo.numActivities = ${runInfo.numActivities}")
                        sb.append("\n\t-runInfo.numRunning = ${runInfo.numRunning}")
                        sb.append("\n\t-top.packageName = ${top!!.packageName}")
                        sb.append("\n\t-top.className = ${top.className}")
                        sb.append("\n\t-base.packageName = ${base.packageName}")
                        sb.append("\n\t-base.className = ${base.className}")
                        if (isFileLog) {
//                            getLogger(trace).error(sb.toString())
                        } else {
                            Log.e("[$trace]", sb.toString())
                        }
                    } else {
                        sb.append("\n\t-base.className = ${base.className}")
                        if (isFileLog) {
//                            getLogger(trace).info(sb.toString())
                        } else {
                            Log.i("[$trace]", sb.toString())
                        }
                    }
                }
                val services = am.getRunningServices(Int.MAX_VALUE)
                val isServiceFound = false
                for (i in services.indices) {
                    if (context.packageName == services[i].service.packageName) {
                        if (isFileLog) {
//                            getLogger(trace).error(services[i].service.className)
                        } else {
                            Log.e("[$trace]", services[i].service.className)
                        }
                    }
                }
            } catch (e: Exception) {
                if (isFileLog) {
//                    getLogger(trace).error(e.toString())
                } else {
                    Log.e("[$trace]", e.toString())
                }
            } finally {
                if (isFileLog) {
//                    getLogger(trace).error("-------------------------------------------------------")
                } else {
                    Log.e("[$trace]", "-------------------------------------------------------")
                }
            }
        }
    }

    @JvmStatic
	fun webViewCookie(url: String?) {
        if (LOG) {
            try {
                val ste = Thread.currentThread().stackTrace[STACK_TRACE_INDEX]
                val trace = ste.className + "." + ste.methodName + ":" + ste.lineNumber
                val cookie = CookieManager.getInstance().getCookie(url)
//                this.i("cookie = $cookie")
                if (cookie != null) {
                    Log.i("[$trace]", URLDecoder.decode(cookie, "utf-8"))
                } else {
                    Log.i("[$trace]", "cookie is null")
                }
            } catch (e: Throwable) {
                e(e)
            }
        }
    }

    init {
        isFileLog = Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
        isFileLog = false
    }
}