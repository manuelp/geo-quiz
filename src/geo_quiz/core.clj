(ns geo-quiz.core)

(def capitals [{:country "Italy" :capital "Rome"}
               {:country "France" :capital "Paris"}
               {:country "Germany" :capital "Berlin"}
               {:country "United Kingdom" :capital  "London"}])

(defn ask-capital
  "Ask the :capital of a :country using the given map and returns 1 if
  the user answered correctly, -1 otherwise."
  [question]
  (do
    (println (format "Enter the capital of %s: " (question :country)))
    (if (= (read-line) (question :capital)) 1 -1)))

(defn ask-capitals
  "Ask to the user the capital of the country coll and returns the sum of
  the points for every answer."
  [questions]
  (reduce + (map ask-capital questions)))

(defn quiz
  "Ask n random capitals from the list."
  [n questions]
  (ask-capitals (take n (shuffle capitals))))
    
(println "RESULT: " (quiz 2 capitals))
