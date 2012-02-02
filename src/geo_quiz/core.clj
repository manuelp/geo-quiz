(ns geo-quiz.core)

(def capitals [{:country "Italy" :capital "Rome"}
               {:country "France" :capital "Paris"}
               {:country "Germany" :capital "Berlin"}
               {:country "United Kingdom" :capital  "London"}])

(defn ask-capital
  "Ask the :capital of a :country using the given map and returns true
  if the user enters the correct answer. False otherwise."
  [question]
  (do
    (println (format "Enter the capital of %s: " (question :country)))
    (= (read-line) (question :capital))))

(defn calculate-points
  "Calculate the new amount of points given a new correct or wrong
  answer. +/- 1 respectively."
  [points correct-answer]
  (if correct-answer
    (inc points)
    (dec points)))

(defn ask-capitals [questions]
  "Ask the capitals and calculate the amount of points totalized
  given the user's answers."
  (loop [qs questions points 0]
    (if (empty? qs)
      points
      (recur (rest qs) (calculate-points points (ask-capital (first qs)))))))

(defn quiz
  "Ask n random capitals from the list."
  [n questions]
  (ask-capitals (take n (shuffle capitals))))
    
(println "RESULT: " (quiz 2 capitals))
