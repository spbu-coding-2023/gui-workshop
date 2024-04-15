# Презентация

## Сборка

С помощью *pdflatex*

```bash
./make.sh
```

Если *pdflatex* не установлен, можжно собрать с помощью Docker

```bash
docker run --rm -i \
  --user="$(id -u):$(id -g)" \
  -v $PWD:/data blang/latex:latest \
  /bin/bash ./make.sh
```

Результат сборки - файл [./presentation.pdf](./presentation.pdf)

## Удаление промежуточных файлов

```bash
./clean.sh
```