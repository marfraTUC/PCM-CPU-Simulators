# Create Line Chart

threadsX <- c(1,2,4,8,16)

## 8 CORE Model
#maxSim1MTransY <- c(107.0273,107.2839,57.9941,43.4319,125.1840)
## 16 CORE Model
maxSim1MTrans16CoreY <- c(135.0646,88.9265,63.7140,51.3343,45.7820)
maxsimY_SD = 0.1



# get the range for the x and y axis 
xrange <- range(1:16) 
yrange <- range(40:145) 

# set up the plot 
plot(xrange, yrange, type="n", xlab="Threads (Number)",
     ylab="Executiontime (s)", xaxt="n", pch=5, axes=FALSE) 

axis(side=1, at=threadsX)
axis(side=2,seq(40, 145, by=10), las=1) 
box()

grid(nx = NULL, ny = NULL, col = "lightgray", lty = "dotted" )

# standard Abweichung
arrows(threadsX, maxSim1MTrans16CoreY-(maxSim1MTrans16CoreY*maxsimY_SD), threadsX, maxSim1MTrans16CoreY+(maxSim1MTrans16CoreY*maxsimY_SD), code = 3, angle = 90, length = 0.05)

# add lines 
#lines(threadsX,maxSim1MTransY,type="b", lwd=1.5, lty=1, col="red")
lines(threadsX,maxSim1MTrans16CoreY,type="b", lwd=1.5, lty=2, col="blue")

# add a title and subtitle 
title("MaxSim: Simulated Executiontime")

# add a legend 
#legend("bottomleft", legend=c("8 Core ", "16 Core "), col=c("red", "blue"), lty=1:2, cex=0.8)