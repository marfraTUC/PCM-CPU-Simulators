
# Connecting Palladio with Multicore CPU Simulators


#### Contributors 

( Sebastian Graef - <st115283@stud.uni-stuttgart.de> )

( Markus Frank - <markus.frank@iste.uni-stuttgart.de> ) 

#### Additional Literature
Connecting Palladio with Multicore CPU Simulators
https://elib.uni-stuttgart.de/bitstream/11682/10205/1/2018_Sebastian_Graef_BSc.pdf

#### Structure
- `/MaxSim` contains MaxSim Simulator.
- `/Bank Account Models` contains all PCM Models for the BankAccount Use Case.
- `/Simulators/docker` folder contains all Simulators and their building `Dockerfiles`.
- `/Experiment Results/MaxSim` contains all Simulation results from MaxSim.
- `/ProtoCom Java SE Docker Example/` contains a docker example for a Java SE performance prototype.


#### Simulator Setup
The aim of this repos and the coresponding thesises is tp connecting Palladio to MaxSim.

##### Requirements
- Operation-Systems: Linux, MacOS, Windows
- Software Requirements:
    - Docker

##### Commands

###### Option 1:
Lode the prebuild docker image with `docker pull 87t8kt3opuqv4solbce3/maxsim` run the loaded docker image with `docker run --privileged --rm -it "nameOfDockerImage"`

List of all the docker images of the different Simulators: 
- docker pull 87t8kt3opuqv4solbce3/maxsim
- docker pull 87t8kt3opuqv4solbce3/tejas
- docker pull 87t8kt3opuqv4solbce3/tejasjava
- docker pull 87t8kt3opuqv4solbce3/zsim
- docker pull 87t8kt3opuqv4solbce3/sniper
- docker pull 87t8kt3opuqv4solbce3/multi2sim
- docker pull 87t8kt3opuqv4solbce3/gem5




###### Option 2:
1. (ON HOST) `cd docker/MaxSim/`
2. (ON HOST) `docker build ./` - can take up to 1 h (needs a lot of memory for gem5 so you might need to increase it)
3. (ON HOST) `docker run --privileged --rm -it "name of docker image"` - to get the name of the docker image use `docker images`

To run own jars copy them into the running docker container (`docker ps` shows the list of all running container):
1. (ON HOST) `docker cp <path_of_local.jar> <docker-ID>:/usr/local/src/runPrototype.jar`
2. (ON CONTAINER) write an configuration an save it at the `zsim/tests/` folder. OR use the given one `zsim/tests/runPrototype16Core.cfg`
3. (ON CONTAINER) start the Simulation: `./zsim/build/release/zsim zsim/tests/runPrototype16Core.cfg`

 Addapt this line `-cp /usr/local/src/calibrationTool.jar me.graef.sebastian.bachelor.thesis.Main` in your config to use the right MainClass! 
