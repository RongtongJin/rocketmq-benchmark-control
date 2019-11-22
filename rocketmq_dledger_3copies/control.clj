(defcluster :rocketmq
            :clients [{:host "172.16.64.149" :user "root"}
                      {:host "172.16.64.150" :user "root"}
                      {:host "172.16.64.151" :user "root"}])

(deftask :date "echo date on cluster" []
         (ssh "date"))


(deftask :start []
         (ssh
           (run
             (cd "/root/rocketmq_dledger_3copy/"
                 (run "sh bin/brokerstartup.sh -n 172.16.64.152:9876 -c conf/broker.conf")))))

(deftask :stop []
         (ssh
           (run
             (cd "/root/rocketmq_dledger_3copy/"
                 (run "sh bin/mqshutdown broker")))))

(deftask :clear []
         (ssh
           (run "rm -rf ~/store")))
