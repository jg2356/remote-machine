(ns remote-machine.visitor)

(def ^:dynamic *symbols* nil)

(defmulti visit #(keyword ( % :type)))

(defmethod visit :prog [{:keys [children]}]
  (map visit children))

(defmethod visit :binop [{:keys [left right op]}]
  (let [lv (visit left)
        rv (visit right)]
    (case op
      "+" (+ lv rv)
      "-" (- lv rv)
      "*" (* lv rv)
      "/" (/ lv rv)
      (throw (new RuntimeException (str "unsupported op: " op))))))

(defmethod visit :assign [{:keys [id value]}]
  (let [value (visit value)]
    (swap! *symbols* assoc id value)
    value))

(defmethod visit :var [{:keys [id]}]
  (or (get @*symbols* id)
      (throw (new RuntimeException (str "undefined var: " id)))))

(defmethod visit :double [{:keys [value]}]
  value)
