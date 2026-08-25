## Modelo de capas (ej. modelo OSI o TCP/IP)

El concepto clave es:

- **Las capas definen responsabilidades** → qué tipo de problema resuelven (físico, enrutamiento, transporte, aplicación, etc.)
- **Los protocolos definen las reglas** → *cómo* se resuelve ese problema dentro de cada capa.

```
┌─────────────────────────────────────────────┐
│  Capa 7 - Aplicación    → HTTP, FTP, SMTP   │
├─────────────────────────────────────────────┤
│  Capa 4 - Transporte    → TCP, UDP          │
├─────────────────────────────────────────────┤
│  Capa 3 - Red           → IP, ICMP          │
├─────────────────────────────────────────────┤
│  Capa 2 - Enlace        → Ethernet, Wi-Fi   │
├─────────────────────────────────────────────┤
│  Capa 1 - Física        → cables, señales   │
└─────────────────────────────────────────────┘
```

## Analogía simple

Pensalo como un **servicio de correo**:

| Capa | Responsabilidad | Protocolo (reglas) |
|------|----------------|-------------------|
| Capa de aplicación | Qué quiero enviar | Formato de la carta, idioma |
| Capa de transporte | Cómo lo hago llegar confiable | Certificado de entrega, seguimiento |
| Capa de red | Por dónde viaja | Ruta que sigue el camión |
| Capa de enlace | Transporte local | Vehículo específico (camión, bici) |

## Entonces

- **No** es que un protocolo defina las capas.
- **Sí** es que cada capa puede tener **múltiples protocolos**, y vos elegís uno según lo que necesites.
- Los protocolos de capas diferentes **colaboran** entre sí para lograr la comunicación completa (ej: HTTP sobre TCP sobre IP sobre Ethernet).

La **arquitectura en capas** es el marco organizativo; los **protocolos** son las herramientas concretas que cada capa usa.