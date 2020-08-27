#!/bin/bash
#clear file
echo -n "" > BankInputFailing.txt

accountNumber=5000
balanceRange=4999
transactionNumber=100000
maxTrabsactionAmount=700

counter=0
while [ $counter -lt $accountNumber ]; do
#    randomNumber=$RANDOM
    randomNumber=1
#    let "randomNumber %= $balanceRange"
    let balance=randomNumber+1
    echo $balance >> BankInputFailing.txt
    let counter=counter+1
done

echo -e "\r" >> BankInputFailing.txt

counter=0

#while [ $counter -lt 2500 ];do
#while [ $counter -lt $transactionNumber ];do
#    randomSrcAcc=$RANDOM
#    randomTrgAcc=$RANDOM
#    randomAmount=$RANDOM

while [ $counter -lt 2500 ];do
    randomSrcAcc=$counter
    let randomTrgAcc=$counter+2500
    randomAmount=5

#    let "randomSrcAcc %= $accountNumber"
#    let "randomTrgAcc %= $accountNumber"
#    if [ $randomSrcAcc -ne $randomTrgAcc ]
#    then
#        let "randomAmount %= $maxTrabsactionAmount"
#        let randomAmount=randomAmount+5

    for ((i=1; i<=1000; i++)); do
    echo $randomSrcAcc $randomTrgAcc $randomAmount >> BankInputFailing.txt
    done
 
    let counter=$counter+1
done
#    fi

