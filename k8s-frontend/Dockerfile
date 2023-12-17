FROM node:alpine
WORKDIR /app
COPY package*.json .
RUN npm install
COPY . .
EXPOSE 3131
CMD [ "npm", "run", "dev"]