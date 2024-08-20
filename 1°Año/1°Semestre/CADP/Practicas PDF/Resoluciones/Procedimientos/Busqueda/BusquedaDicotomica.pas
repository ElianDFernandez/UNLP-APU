procedure busquedaDicotomica(var vec:numeros; diml:integer; num:integer; var ok:boolean);
var 
    pri,ult,medio:integer;
begin 
    ok:=false;
    pri:=1; ult:=diml; medio:=(pri+ult) div 2;
    while (pri <= ult ) and (bus <> vec[medio]) do begin 
        if (num < v[medio]) then 
            ult:= medio-1
        else 
            pri:= medio+1;
        medio := (pri + ult) div 2;
    end;
    if (pri <= ult) and (v[medio] = num) then ok:=true;
end;    