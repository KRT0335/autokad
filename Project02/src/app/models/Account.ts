export class Account {
  private id: number;
  private name: string;
  private username: string;
  private password: string;

  constructor(id: number, name: string, username: string, password: string) {
    this.id = id;
    this.name = name;
    this.username = username;
    this.password = password;
  }
  getId(): number {
    return this.id;
  }
  setId(id: number) {
    this.id = id;
  }
  getName(): string {
    return this.name;
  }
  setName(name: string) {
    this.name = name;
  }
  getUsername(): string {
    return this.username;
  }
  setUsername(username: string) {
    this.username = username;
  }
  getPassword(): string {
    return this.password;
  }
  setPassword(password: string) {
    this.password = password;
  }
}