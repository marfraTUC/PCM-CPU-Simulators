## set up some fake test data

threadsX <- c(1,2,4,8,16)
simucomY <- c(16607.6075,8305.9576,4153.2606,2076.4026,1038.5950)
speedup <- c(1,2,4,8,16)

# get the range for the x and y axis 
xrange <- range(1:16) 
yrange <- range(1000:16800) 
yrange2 <- range(1:17) 

## add extra space to right margin of plot within frame
par(mar=c(5, 6, 4, 4.5) + 0.1)

## Plot first set of data and draw its axis
plot(xrange, yrange, type="n", xlab="",
     ylab="", xaxt="n", pch=5, axes=FALSE) 

axis(2, ylim=yrange,las=1)  ## las=1 makes horizontal labels
mtext("Executiontime (s)",side=2,line=4)

#grid(nx = NULL, ny = NULL, col = "lightgray", lty = "dotted" )

# add lines 
lines(threadsX,simucomY,type="b", lwd=1.5, lty=1, col="red")

# add a title and subtitle 
title("SimuCom: Simulated Executiontime")
box()

## Allow a second plot on the same graph
par(new=TRUE)

## Plot the second plot and put axis scale on right
plot(xrange, yrange2, xlab="", ylab="", axes=FALSE, type="b")
# add lines 
lines(threadsX,speedup,type="b", lwd=1.5, lty=2, col="blue")

## a little farther out (line=4) to make room for labels
axis(4, ylim=yrange2 ,las=1)
mtext("Speedup", side=4 ,line=2.5) 

## Draw the time axis
axis(1, at=threadsX)
mtext("Threads (Number)",side=1,line=2.5)

## Add Legend
legend("topleft",legend=c("Executiontime","Speedup"), lty=c(1,2),col=c("red","blue"))

