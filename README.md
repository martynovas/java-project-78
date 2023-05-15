# Валидатор данных
Библиотека, с помощью которой можно проверять корректность любых данных.

Пример использования:
```java
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;

Validator v = new Validator();

// строки
StringSchema schema = v.string().required();

schema.isValid("what does the fox say"); // true
schema.isValid(""); // false

// числа
NumberSchema schema = v.number().required().positive();

schema.isValid(-10); // false
schema.isValid(10); // true

// объект Map с поддержкой проверки структуры
Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());

MapSchema schema = v.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "");
human2.put("age", null);
schema.isValid(human1); // false
```

### Hexlet tests and linter status:
[![Actions Status](https://github.com/martynovas/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/martynovas/java-project-78/actions)

### Codeclimate Maintainability
[![Maintainability](https://api.codeclimate.com/v1/badges/683282bb98f16643a501/maintainability)](https://codeclimate.com/github/martynovas/java-project-78/maintainability)

### Codeclimate Test Coverage
[![Test Coverage](https://api.codeclimate.com/v1/badges/683282bb98f16643a501/test_coverage)](https://codeclimate.com/github/martynovas/java-project-78/test_coverage)
