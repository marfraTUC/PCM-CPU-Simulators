#!/bin/bash
#clear file
echo -n "" > BankInput2MEasyV2.txt

accountNumber=5000
balanceRange=2000
transactionNumber=2000000
maxTrabsactionAmount=70

counter=0
while [ $counter -lt $accountNumber ]; do
    let balance=balanceRange
    echo $balance >> BankInput2MEasyV2.txt
    let counter=counter+1
done

echo -e "\r" >> BankInput2MEasyV2.txt

counter=0

while [ $counter -lt 2500 ];do
    randomSrcAcc=$counter

    let randomTrgAcc=$counter+2500

    for ((i=1; i<=400; i++)); do
 
    	randomAmount=$RANDOM
    	let "randomAmount %= $maxTrabsactionAmount"
    	let randomAmount=randomAmount+1

  	echo $randomSrcAcc $randomTrgAcc $randomAmount >> BankInput2MEasyV2.txt
    done
 
    let counter=$counter+1
done

