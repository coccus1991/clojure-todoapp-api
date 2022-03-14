(defproject clojure-todoapp-api "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [
                 [org.clojure/clojure "1.10.1"]
                 [http-kit "2.3.0"]
                 [lynxeyes/dotenv "1.0.2"]
                 [compojure "1.6.2"]
                 [org.clojure/data.json "2.4.0"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-devel "1.6.3"]
                 [ring/ring-json "0.5.0"]]
  :repl-options {:init-ns clojure-todoapp-api.core}
  :main clojure-todoapp-api.core/-main
  )
