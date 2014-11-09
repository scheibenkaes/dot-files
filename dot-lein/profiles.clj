{:user {:plugins [[lein-midje "3.1.1"]
                  [lein-ancient "0.5.4"]
                  [lein-marginalia "0.7.1"]
                  [com.cemerick/austin "0.1.5"]]
        :dependencies [[clj-stacktrace "0.2.7"]]
        :injections [(let [orig (ns-resolve (doto 'clojure.stacktrace require)
                                            'print-cause-trace)
                           new (ns-resolve (doto 'clj-stacktrace.repl require)
                                           'pst)]
                       (alter-var-root orig (constantly (deref new))))]}}
