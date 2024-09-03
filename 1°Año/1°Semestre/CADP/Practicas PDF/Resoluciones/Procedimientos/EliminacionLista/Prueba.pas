program ejer;
type
  TPersona = record
    Nombre: string;
    Edad: Integer;
  end;

function CrearPersona(Nombre: string; Edad: Integer): TPersona;
begin
  // Asignar valores al registro
  CrearPersona.Nombre := Nombre;
  CrearPersona.Edad := Edad;
end;

var
  persona: TPersona;
begin
  persona := CrearPersona('Juan', 30);
  WriteLn('Nombre: ', persona.Nombre);
  WriteLn('Edad: ', persona.Edad);
end.