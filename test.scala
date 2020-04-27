object Test {
    def main(args: Array[String]) = {
        val mainThread = Thread.currentThread();
        var breaking_flag = false
        sys.addShutdownHook({
/* it is necessary to join() back to the main thread from within the shutdown hook as below because, unlike C signal handlers, the process terminates at the end of the shutdown handler, even though there is no explicit call to System.exit().
*/
            println("Gracefully stopping")
            breaking_flag = true
            println(breaking_flag)
            mainThread.join()
        })

        println("Start counting..")
        while(!breaking_flag){   
            print(!breaking_flag)
            print("  ")
            val items = (1 to 10).toList
            items.map(i => {
                print(i)
                print("..")
                Thread.sleep(100)
            })
            println("GO")
            Thread.sleep(1000)
        }
        println("Goodbye..")
    }
}
