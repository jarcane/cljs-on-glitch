(require 'lumo.build.api)

(lumo.build.api/build "src" {:main "app.main"
                             :optimizations :none
                             :output-dir "public/js/out"
                             :asset-path "js/out"
                             :output-to "public/main.js"
                             :verbose true
                             :npm-deps {:hyperapp "1.2.8"}})
