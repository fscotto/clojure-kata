(ns fscotto.random-clojure-function
  (:gen-class)
  (:require [org.httpkit.server :as server]))

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

(defonce webserver (atom nil))

(defn start-server
  "Start application server"
  [handler]
  (let [port (Integer/parseInt (or (System/getenv "PORT") "8080"))]
    (reset! webserver (server/run-server handler {:port port}))
    (println (str "Running webserver at 127.0.0.1:" port))))

(defn stop-server
  "Stop application server"
  []
  (when-not (nil? webserver)
    (@webserver :timeout 100)
    (reset! webserver nil)))

(defn -main
  "Return a random function and its details
   from the available namespaces"
  [& args]
  (start-server (fn [req]
                  {:status 200
                   :headers {"Contenty-Type" "text/html"}
                   :body (if (seq args)
                           (random-function (mapcat #(function-list (symbol %)) args))
                           (random-function available-namespaces))})))
