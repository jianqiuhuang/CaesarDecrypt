#! /bin/bash

# Usage: ./ceaserCipher_v1.0.sh <input-file-name> <output-file-name> <number-of-lines> <shift by chars>

count=0
inputfilename="in.txt"
outputfilename="out.txt"
#function cipher() will convert the given input text to cipher text using ceaser cipher algorithm
#Base is assumed to be 13 if not specified.
#
# Bases not in 0-25 are taken modulo 26; negatives are increased by
# 26es until they're positive. Thus, any integer should work
# as expected.

function cipher() {

	local pattern='^-?[0-9]+$'

	if [[ $1 =~ $pattern ]]; # Is first argument an integer?
	then
		local base="$1"
		local string="$2"
		local origbase="$1" # Save original base for later clarification
	else
		local base="13"
		local string="$1"
		local origbase="null"
	fi

	while (($base < 0))
	do
		base=$(($base + 26)) # Modulo ought to work this way
	done

	local realbase=$(($base % 26))

	local cipher0='A-Za-z'
	local cipher1='B-ZAb-za'
	local cipher2='C-ZA-Bc-za-b'
	local cipher3='D-ZA-Cd-za-c'
	local cipher4='E-ZA-De-za-d'
	local cipher5='F-ZA-Ef-za-e'
	local cipher6='G-ZA-Fg-za-f'
	local cipher7='H-ZA-Gh-za-g'
	local cipher8='I-ZA-Hi-za-h'
	local cipher9='J-ZA-Ij-za-i'
	local cipher10='K-ZA-Jk-za-j'
	local cipher11='L-ZA-Kl-za-k'
	local cipher12='M-ZA-Lm-za-l'
	local cipher13='N-ZA-Mn-za-m'
	local cipher14='O-ZA-No-za-n'
	local cipher15='P-ZA-Op-za-o'
	local cipher16='Q-ZA-Pq-za-p'
	local cipher17='R-ZA-Qr-za-q'
	local cipher18='S-ZA-Rs-za-r'
	local cipher19='T-ZA-St-za-s'
	local cipher20='U-ZA-Tu-za-t'
	local cipher21='V-ZA-Uv-za-u'
	local cipher22='W-ZA-Vw-za-v'
	local cipher23='X-ZA-Wx-za-w'
	local cipher24='Y-ZA-Xy-za-x'
	local cipher25='ZA-Yza-y'

	local funcname="cipher${realbase}"

	# If the base was converted above, send the actual 0-25 base to stderr

	if (($origbase != $realbase))
	then
		echo "(ROT-${realbase})" 1>&2
	fi

	echo "$string" | tr 'A-Za-z' "${!funcname}" >> $outputfilename

}

#This function generates a random set of strings
function generateStrings()
{
	
	#local count=10
	local c
	for (( c=1; c<=$count; c++ ))
		do
			cat /dev/urandom | env LC_CTYPE=C tr -dc 'a-zA-Z' | fold -w 10 | head -n 1 >>  $inputfilename
		done

}



if [ "$#" -eq 4 ]; then
 	count=$3; 

 	if [ $count -le 0 ]; then
  		echo "Enter a valid count greater than zero"
		exit 1
	fi

	if [ -e $2 ]; then
		rm "$2";
	fi

	if [ -e $1 ]; then
		rm "$1";
	fi

	inputfilename=$1;
	outputfilename=$2;
	echo "Input file name: $1"
	echo "Output file name: $2"
	echo "Number of lines: $3"
	echo "Shift: $4"
	

	generateStrings

 else
	echo "Usage: ./ceaserCipher_v1.0.sh <input-file-name> <output-file-name> <number-of-lines> <shift by chars>"
	exit 1
fi


while read line           
do          
    cipher "$4" $line           
done < "$1"

