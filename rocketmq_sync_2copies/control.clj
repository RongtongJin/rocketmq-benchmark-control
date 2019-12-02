(defcluster :rocketmq
            :clients [{:host "172.16.64.176" :user "root"}
                      {:host "172.16.64.178" :user "root"}])

(deftask :date "echo date on cluster" []
         (ssh "date"))


(deftask :start []
         (ssh
           (run
             (cd "/root/rocketmq_sync"
                 (run "sh bin/brokerstartup.sh -n 172.16.64.165:9876 -c conf/broker.conf")))))

(deftask :stop []
         (ssh
           (run
             (cd "/root/rocketmq_sync/"
                 (run "sh bin/mqshutdown broker")))))

(deftask :clear []
         (ssh
           (run "rm -rf ~/store")))
