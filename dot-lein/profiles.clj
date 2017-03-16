{:user {:plugins [[lein-ancient "0.6.10"]]
        :signing {:gpg-key "F2C8C71C"}
        :dependencies [[clj-stacktrace "0.2.8"]]
        :injections [(let [orig (ns-resolve (doto 'clojure.stacktrace require)
                                            'print-cause-trace)
                           new (ns-resolve (doto 'clj-stacktrace.repl require)
                                           'pst)]
                       (alter-var-root orig (constantly (deref new))))]}

 :repl {:dependencies [[org.clojure/tools.nrepl "0.2.12"]]}}
