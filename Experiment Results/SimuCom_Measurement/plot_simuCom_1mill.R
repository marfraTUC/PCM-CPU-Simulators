# Create Line Chart

simucomX <- c(1,2,4,8,16)

#for 1mill Transactions
simucomY <- c(16607.6075,8305.9576,4153.2606,2076.4026,1038.5950)



# get the range for the x and y axis 
xrange <- range(1:16) 
yrange <- range(1000:16800) 

# set up the plot 
plot(xrange, yrange, type="n", xlab="Threads (Number)",
     ylab="Executiontime (s)", xaxt="n", pch=5) 
axis(1, at=simucomX)

grid(nx = NULL, ny = NULL, col = "lightgray", lty = "dotted" )

# add lines 
lines(simucomX,simucomY,type="b", lwd=1.5, lty=1, col="red")

# add a title and subtitle 
title("SimuCom: Simulated Executiontime")

# add a legend 
#legend("topright", legend=c("Line 1", "Line 2"), col=c("red", "blue"), lty=1:2, cex=0.8)