(defproject remote-machine "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-time "0.9.0"]
                 [metosin/compojure-api "0.21.0"]]
  :ring {:handler remote-machine.handler/app}
  :uberjar-name "remote-machine.jar"
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]]
                   :plugins [[lein-ring "0.9.4"]]}})
