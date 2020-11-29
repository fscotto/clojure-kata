(defproject fscotto/random-clojure-function "0.1.0-SNAPSHOT"
  :description "Semplice libreria Clojure per la documentazione di una funzione random"
  :url "https://github.com/fscotto/clojure-kata/tree/main/random-clojure-function"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :main ^:skip-aot fscotto.random-clojure-function
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
