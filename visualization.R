data <- read.csv(file="/users/psprao/eclipse-workspace/network-reliability/pVsR.csv")

# Getting K, cost and density  data
p<-data[,1]
r<-data[,2]


# Scatterplot of K vs Cost of Network
plot(p,r,xlab="p",ylab="reliability ",main="Link Reliability vs Network Reliability")
lines(r~p)


data <- read.csv(file="/users/psprao/eclipse-workspace/network-reliability/kVsR.csv")

# Getting K, cost and density  data
k<-data[,1]
r<-data[,2]


# Scatterplot of K vs Cost of Network
plot(k,r,xlab="k",ylab="reliability ",main="K vs Reliability (p=0.87) ")
lines(r~k)

