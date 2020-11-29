(ns fscotto.random-clojure-function-test
  (:require [clojure.test :refer [deftest is testing]]
            [fscotto.random-clojure-function :as SUT]))

(deftest -main-test
  (testing "Show random function name from Clojure Standard Library"
    (is (seq SUT/clojure-core))
    (is (string? (SUT/random-function SUT/clojure-core)))))
