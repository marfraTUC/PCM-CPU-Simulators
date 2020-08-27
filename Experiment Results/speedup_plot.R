# Create Line Chart

threadsX <- c(1,2,4,8,16)

simucomY <- c(1.0000,1.9995,3.9987,7.9983,15.9905)
realY <- c(1.0000,2.2973,4.6598,7.9381,9.1646)
maxsimY<- c(1.0000,1.5188,2.1199,2.6311,2.9502)

maxsimY_SD = 0.15
realY_SD = c(0.11,0.03,0.04,0.06,0.07)

# get the range for the x and y axis 
xrange <- range(1:16) 
yrange <- range(1:16)

# set up the plot 
plot(xrange, yrange, type="n", xlab="Threads (Number)",
     ylab="Speedup", xaxt="n", pch=5, axes=FALSE) 


axis(side=1, at=threadsX)
axis(side=2, seq(0, 16, by=2), las=1)
box()

grid(nx = NULL, ny = NULL, col = "lightgray", lty = "dotted" )

# standard Abweichung
arrows(threadsX, maxsimY-(maxsimY*maxsimY_SD), threadsX, maxsimY+(maxsimY*maxsimY_SD), code = 3, angle = 90, length = 0.05)
# standard Abweichung
arrows(threadsX, realY-(realY*realY_SD), threadsX, realY+(realY*realY_SD), code = 3, angle = 90, length = 0.05)

# add lines 
lines(threadsX,realY,type="b", lwd=1.5, lty=1, col="red")
lines(threadsX,simucomY,type="b", lwd=1.5, lty=2, col="blue")
lines(threadsX,maxsimY,type="b", lwd=1.5, lty=3, col="green")

# add a title and subtitle 
title("Simulated Speedup")

# add a legend 
legend("topleft", legend=c("Realitly  ", "SimuCom ", "MaxSim "), col=c("red", "blue", "green"), lty=1:3, cex=0.8)
