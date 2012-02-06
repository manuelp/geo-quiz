(ns geo-quiz.core)

(defn quiz
  "Ask n random capitals from the list."
  [n questions]
  (let [capitals [{:country "Italy" :capital "Rome"}
                  {:country "France" :capital "Paris"}
                  {:country "Germany" :capital "Berlin"}
                  {:country "United Kingdom" :capital  "London"}]]
    (letfn [(ask-capital [question]
              (do
                (println (format "Enter the capital of %s: " (:country question)))
                (if (= (read-line) (:capital question)) 1 -1)))
            (ask-capitals [questions] (reduce + (map ask-capital questions)))]
      (ask-capitals (take n (shuffle capitals))))))
    
(println "RESULT: " (quiz 2 capitals))
