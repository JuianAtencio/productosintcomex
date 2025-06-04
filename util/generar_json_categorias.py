import json

categorias = []
for i in range(1, 11):
    categoria = {
        "categoryId": i,
        "categoryName": f"Categoría {i}",
        "description": f"Descripción de la categoría {i}",
        "picture": f"https://example.com/pictures/categoria_{i}.jpg"
    }
    categorias.append(categoria)

with open("categorias_bulk.json", "w", encoding="utf-8") as f:
    json.dump(categorias, f, ensure_ascii=False, indent=2)

print("Archivo categorias_bulk.json generado con 10 categorías.")