- Трудности с регистрацией из России (смс не приходит, карту регать не хочется): ставим gitlab на локальную ВМ

```yaml
image: alpine:latest

pages:
  stage: deploy
  script:
  - echo 'First page 01'
  - mkdir .public
  - cp -r * .public
  - mv .public public
  artifacts:
    paths:
    - public
    exclude:
    - public/file_to_exclude.md
  only:
  - master

```
Gitlab Runner развернут на ВМ, запущен для проекта. Статус: passed.

- Исключение файла из папки с артефактами:
```yaml
...
  artifacts:
    paths:
    - public
    exclude:
    - public/file_to_exclude.md
...

```

## Скрины
![img2.png](img%2Fimg2.png)
![img3.png](img%2Fimg3.png)