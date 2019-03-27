<?php
    $conn = mysqli_connect("localhost", "root", "SomethingUncreative", "Unlazy");
    
    $username = $_POST["username"];
    $password = $_POST["password"];

    $sql = mysqli_prepare($conn, "SELECT * from users WHERE username = ?")
    mysqli_stmt_bind_param($sql, "s", $username);
    mysqli_stmt_execute($sql);
    mysqli_stmt_store_result($sql);
    mysqli_stmt_bind_result($sql, $colUserID, $colUsername, $colPassword, $colEmail);

    $response = array();
    $response["success"] = false;  

    while(mysqli_stmt_fetch($sql)){
        if (password_verify($password, $colPassword)) {
            $response["success"] = true;
            $response["id"] = $colUserID;
            $response["username"] = $colUsername;
            $response["email"] = $colEmail;
        }
    }

    echo json_encode($response)
?>