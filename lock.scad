union(){
    difference(){
    cylinder(r=15.75/2, h=30);
    for(i=[0:90:270]){
        rotate([0,0,i]) translate([15.75/2,0,25/2]) sphere(r=1.3);
    }
    }
    translate([0,0,30]) difference(){
        translate([0,0,75/2])cube([23,23,75],center=true);
        translate([0,0,72/2+3])cube([20,20,72],center=true);
    }
}