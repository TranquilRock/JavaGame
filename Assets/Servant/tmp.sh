for s in "Dead" "Shoot" "Idle" "Run"
do
	mkdir $s
	for i in $(seq 0 20)
	do
		mv "$s ($i).png" "./$s/$i.png";
	done
done
