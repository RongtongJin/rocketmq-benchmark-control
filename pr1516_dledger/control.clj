(defcluster :rocketmq
            :clients [{:host "172.16.64.176" :user "root"}
                      {:host "172.16.64.177" :user "root"}
                      {:host "172.16.64.178" :user "root"}])

(deftask :date "echo date on cluster" []
         (ssh "date"))


(deftask :start []
         (ssh
           (run
             (cd "pr1516/rocketmq/distribution/target/rocketmq-4.6.0-SNAPSHOT/rocketmq-4.6.0-SNAPSHOT/"
                 (run "sh bin/brokerstartup.sh -n 172.16.64.165:9876 -c conf/broker.conf")))))

(deftask :stop []
         (ssh
           (run
             (cd "pr1516/rocketmq/distribution/target/rocketmq-4.6.0-SNAPSHOT/rocketmq-4.6.0-SNAPSHOT/"
                 (run "sh bin/mqshutdown broker")))))

(deftask :clear []
         (ssh
           (run "rm -rf /tmp/rmqstore")))
