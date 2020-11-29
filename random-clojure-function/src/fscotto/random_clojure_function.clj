(ns fscotto.random-clojure-function
  (:gen-class))

(def clojure-core
  "Fully qualified function makes from clojure.core"
  (vals (ns-publics 'clojure.core)))

(def available-namespaces
  "Fully qualified function names from available"
  (mapcat #(vals (ns-publics %)) (all-ns)))

(defn function-list
  [namespace]
  (vals (ns-publics namespace)))

(defn random-function
  [function-list]
  (let [function-details (meta (rand-nth function-list))]
    (str (function-details :ns) "/" 
         (function-details :name) "\n " 
         (function-details :arglists) "\n " 
         (function-details :doc))))

(defn -main
  "Return a random function and its details
   from the available namespaces"
  [& args]
  (if (seq args)
    (println (random-function (mapcat #(function-list (symbol %)) args)))
    (println (random-function available-namespaces))))
