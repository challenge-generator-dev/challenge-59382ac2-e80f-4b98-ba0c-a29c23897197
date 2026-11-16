# Aprovisionamiento de Infraestructura con Terraform para el Servicio de Ordenes

El objetivo de este reto es aprovisionar la infraestructura AWS necesaria para el servicio de ordenes utilizando Terraform. Deberás versionar la infraestructura y usar modulos de Terraform separados por red, computo y base de datos. El estado remoto de Terraform se guardará en S3. No se permitirá el uso de Lombok en el codigo Java.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Infraestructura como codigo para el servicio de ordenes |
| **Nivel** | senior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y entregará cada archivo con su ruta.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y entregará cada archivo con su ruta. Guárdalos en la carpeta donde quieras trabajar, respetando las rutas.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no entrega todos los archivos al terminar el análisis, escríbele: "entrégame todos los archivos con su ruta".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Configuración Inicial de Terraform

**Objetivo:** Configurar el entorno de Terraform y crear los modulos básicos para red, computo y base de datos.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Configura Terraform para trabajar con AWS.
- Crea modulos de Terraform separados para red, computo y base de datos.
- Configura el estado remoto de Terraform en S3.

**Entregable:** Modulos de Terraform configurados y estado remoto en S3.

<details>
<summary>Pistas de conocimiento</summary>

- Usa Terraform para definir la infraestructura como código.
- Recuerda no usar Lombok en el codigo Java.

</details>

### Fase 2: Aprovisionamiento de la Infraestructura

**Objetivo:** Utilizar los modulos de Terraform creados para aprovisionar la infraestructura AWS necesaria para el servicio de ordenes.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Usa los modulos de Terraform para crear la red, computo y base de datos necesarios.
- Aprovisiona la infraestructura y verifica que todo esté funcionando correctamente.

**Entregable:** Infraestructura AWS aprovisionada y verificada.

<details>
<summary>Pistas de conocimiento</summary>

- Revisa los modulos de Terraform para asegurarte de que están correctamente configurados.
- Verifica que la infraestructura aprovisionada cumple con los requisitos del servicio de ordenes.

</details>

### Fase 3: Versionado de la Infraestructura

**Objetivo:** Versionar la infraestructura creada utilizando Terraform y asegurarte de que el estado remoto esté correctamente configurado en S3.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Versiona la infraestructura creada utilizando Terraform.
- Verifica que el estado remoto en S3 esté correctamente configurado y que se pueda acceder a él.

**Entregable:** Infraestructura versionada y estado remoto en S3 configurado.

<details>
<summary>Pistas de conocimiento</summary>

- Recuerda versionar tu codigo Terraform para mantener un historial de cambios.
- Verifica que el estado remoto en S3 esté correctamente configurado y que se pueda acceder a él.

</details>

### Fase 4: Revisión y Optimización

**Objetivo:** Revisar y optimizar la configuración de Terraform para asegurarte de que la infraestructura sea eficiente y escalable.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Revisa la configuración de Terraform y haz las optimizaciones necesarias para asegurarte de que la infraestructura sea eficiente y escalable.
- Verifica que la infraestructura aprovisionada cumpla con los requisitos de eficiencia y escalabilidad.

**Entregable:** Configuración de Terraform optimizada y verificada.

<details>
<summary>Pistas de conocimiento</summary>

- Revisa los modulos de Terraform para identificar áreas de mejora.
- Verifica que la infraestructura aprovisionada cumpla con los requisitos de eficiencia y escalabilidad.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es Terraform y cómo se utiliza para aprovisionar infraestructura?
- **paraQueSirve**: ¿Para qué sirve versionar la infraestructura utilizando Terraform?
- **comoSeUsa**: ¿Cómo se utilizan modulos de Terraform para separar la configuración por red, computo y base de datos?
- **erroresComunes**: ¿Cuáles son los errores comunes al aprovisionar infraestructura con Terraform y cómo se pueden evitar?
- **queDecisionesImplica**: ¿Qué decisiones implica el versionado de la infraestructura y la configuración del estado remoto en S3?

## Criterios de Evaluacion

- Configuración inicial de Terraform y creación de modulos.
- Aprovisionamiento de la infraestructura utilizando Terraform.
- Versionado de la infraestructura y configuración del estado remoto en S3.
- Revisión y optimización de la configuración de Terraform.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT) si no tenes un agente en el IDE. Declara lo mismo que AGENTS.md; los archivos que te devuelva el chat los guardas en esta carpeta respetando las rutas.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Mapa de componentes

El repo tiene una carpeta por componente. Cada uno se instala y verifica dentro de la suya.

| Componente | Carpeta | Rol | Capa | Track | Tecnologias |
|---|---|---|---|---|---|
| `infra` | `infra/` | practice | infra | Terraform (AWS) | Terraform |
| `api` | `api/` | chapter, support | server | Java | - |

## Orden de arranque

1. `cd infra && terraform init -backend=false && terraform -chdir=environments/dev init -backend=false && terraform -chdir=modules/compute init -backend=false && terraform -chdir=modules/database init -backend=false && terraform -chdir=modules/network init -backend=false && terraform validate && terraform -chdir=environments/dev validate && terraform -chdir=modules/compute validate && terraform -chdir=modules/database validate && terraform -chdir=modules/network validate` — componente `infra` (practice).
2. `cd api && mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` — componente `api` (chapter, support).

### Contratos entre componentes

- `api` expone http (api: http://localhost:8080):
  - `POST /api/orders`
  - `GET /api/orders/{id}`

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
(cd infra && terraform init -backend=false && terraform -chdir=environments/dev init -backend=false && terraform -chdir=modules/compute init -backend=false && terraform -chdir=modules/database init -backend=false && terraform -chdir=modules/network init -backend=false && terraform validate && terraform -chdir=environments/dev validate && terraform -chdir=modules/compute validate && terraform -chdir=modules/database validate && terraform -chdir=modules/network validate) && (cd api && mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package)
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
