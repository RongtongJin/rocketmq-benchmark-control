(defcluster :worker
            :clients [{:host "172.16.64.153" :user "root"}
                      {:host "172.16.64.154" :user "root"}
                      {:host "172.16.64.155" :user "root"}
                      {:host "172.16.64.156" :user "root"}
                      {:host "172.16.64.157" :user "root"}
                      {:host "172.16.64.158" :user "root"}
		      {:host "172.16.64.159" :user "root"}
		      {:host "172.16.64.160" :user "root"}
		      {:host "172.16.64.161" :user "root"}
		      {:host "172.16.64.162" :user "root"}])

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

