FROM node:14-alpine
WORKDIR /usr/src/app
COPY . .
RUN npm install --production
EXPOSE 3000
CMD [ "node", "./bin/www" ]