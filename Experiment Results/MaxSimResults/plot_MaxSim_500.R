# Create Line Chart

threadsX <- c(1,2,4,8,16)

#for 500 Transactions
## 8 CORE Config
#maxSim500TransY <- c(3.9318,3.9331,3.3782,3.4641,3.9402)
## 16 CORE Model
maxSim500Trans16CoresY <- c(11.0785,10.6660,6.3433,5.5420,5.8871)
maxsimY_SD = 0.1

# get the range for the x and y axis 
xrange <- range(1:16) 
yrange <- range(5:12)

# set up the plot 
plot(xrange, yrange, type="n", xlab="Threads (Number)",
     ylab="Executiontime (s)", xaxt="n", pch=5, axes=FALSE) 

# standard Abweichung
arrows(threadsX, maxSim500Trans16CoresY-(maxSim500Trans16CoresY*maxsimY_SD), threadsX, maxSim500Trans16CoresY+(maxSim500Trans16CoresY*maxsimY_SD), code = 3, angle = 90, length = 0.05)


axis(side=1, at=threadsX)
axis(side=2, seq(5, 12, by=1), las=1)
box()

grid(nx = NULL, ny = NULL, col = "lightgray", lty = "dotted" )

# add lines 
#lines(threadsX,maxSim500TransY,type="b", lwd=1.5, lty=1, col="red")
lines(threadsX,maxSim500Trans16CoresY,type="b", lwd=1.5, lty=2, col="blue")

# add a title and subtitle 
title("MaxSim: Simulated Executiontime")

# add a legend 
#legend("bottomleft", legend=c("8 Core ", "16 Core "), col=c("red", "blue"), lty=1:2, cex=0.8)