(ns amicable.core-test
  (:require [amicable.core :refer :all]
            [expectations :refer :all]))

(expect (map find-divisors [2 3 4 5])
        [[1] [1] [1,2] [1]])
