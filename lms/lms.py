from typing import Union
from fastapi import FastAPI
import uvicorn

if __name__ == "__main__":
    # noinspection SpellCheckingInspection
    uvicorn.run('lms:app', reload=True)

app = FastAPI()


@app.get("/")
async def read_root():
    return {"Hello": "World"}


@app.get("/items/{item_id}")
async def read_item(item_id: int, q: Union[str, None] = None):
    return {"item_id": item_id, "q": q}
