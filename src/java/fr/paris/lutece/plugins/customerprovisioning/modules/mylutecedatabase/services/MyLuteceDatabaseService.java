/*
 * Copyright (c) 2002-2016, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.customerprovisioning.modules.mylutecedatabase.services;



import fr.paris.lutece.plugins.customerprovisioning.business.UserDTO;
import fr.paris.lutece.plugins.customerprovisioning.services.IUserInfoProvider;
import fr.paris.lutece.portal.service.security.LuteceUser;
import fr.paris.lutece.portal.service.security.LuteceUserService;

/**
 *
 * MyLuteceDatabaseService service link GRU and MyLuteceDatabase
 */
public class MyLuteceDatabaseService implements IUserInfoProvider
{  
  
     /** 
     * @param strId to make request
     * @return UserDTO else null
     */
    @Override
    public UserDTO getUserInfo( String strId )
    {
        LuteceUser luteceUser = LuteceUserService.getLuteceUserFromName( strId );
        UserDTO user = new UserDTO(  );
        if ( luteceUser != null )
        {
            user.setFirstname( luteceUser.getUserInfo( LuteceUser.NAME_GIVEN ) );
            user.setLastname( luteceUser.getUserInfo( LuteceUser.NAME_FAMILY ) );
            user.setEmail( luteceUser.getEmail(  ) );
            user.setUid( strId );
        }

        return user;
    }

}
