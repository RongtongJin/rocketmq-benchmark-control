(defcluster :worker
            :clients [{:host "172.16.64.163" :user "root"}
                      {:host "172.16.64.164" :user "root"}
                      {:host "172.16.64.166" :user "root"}
                      {:host "172.16.64.167" :user "root"}
                      {:host "172.16.64.168" :user "root"}
                      {:host "172.16.64.169" :user "root"}
																      {:host "172.16.64.170" :user "root"}
																      {:host "172.16.64.171" :user "root"}
																      {:host "172.16.64.172" :user "root"}
																      {:host "172.16.64.173" :user "root"}
																      {:host "172.16.64.174" :user "root"}
																      {:host "172.16.64.175" :user "root"}])

(deftask :start []
         (ssh
           (run
             (cd "/root/openmessaging-benchmark"
                 (run "sh start_worker.sh")))))

(deftask :stop []
         (ssh
           (run
             (cd "/root/openmessaging-benchmark"
                 (run "sh stop_worker.sh")))))

