# Weather Service

Este es un servicio de meteorología que consulta y almacena datos de clima de varias localidades en un caché de Redis, utilizando Ktor en Kotlin. El servicio también expone una API REST para consultar los datos almacenados en el caché.

## Localidades soportadas

- Santiago (CL)
- Zúrich (CH)
- Auckland (NZ)
- Sídney (AU)
- Londres (UK)
- Georgia (USA)

## Tecnologías Utilizadas

- Kotlin
- Ktor
- Redis
- Docker
- Docker Compose

## Configuración del Entorno

### Variables de Entorno

Asegúrate de definir la variable de entorno `API_KEY` para el servicio de meteorología. Puedes hacerlo de dos maneras:

1. **Usar un archivo `.env`**

   Crea un archivo `.env` en el directorio raíz del proyecto con el siguiente contenido:

    ```env
    API_KEY=tu_api_key_aqui
    ```

2. **Definir directamente en la terminal**

   Define la API KEY de api.tomorrow.io como variable de entorno:

    ```bash
    export WEATHER_API_KEY=tu_api_key_aqui
    ```

## Ejecución del Proyecto

### Paso 1: Clonar el repositorio

```bash
git clone https://github.com/tu_usuario/weather-service.git
cd weather-service
```

### Paso 2: Construir y Ejecutar los Contenedores

```bash
docker-compose up -d
```

### Paso 3: Ejecutar el proyecto

```bash
gradlew build
```

### Paso 4: Verificar el Despliegue

```bash
http://localhost:8080/weather/Santiago,CL
```