export class User {
    id!:number;
    fistname!:string;
    lastname!:string;
    bio!:string;
    birthdate!:Date;
    username!:string;
    password!:string;
    email!:string;
    roles!:string[];
    phoneNumber!:number;
    activated!:boolean;
    friends!:User[];
    profilePic!:string;


}

